// LeetCode 1728. Cat and Mouse II
// C++ solution using retrograde analysis (BFS on game states).

class Solution {
public:
    static constexpr int MOUSE_TURN = 0;
    static constexpr int CAT_TURN = 1;
    static constexpr int MOUSE_WIN = 1;
    static constexpr int CAT_WIN = 2;

    bool canMouseWin(vector<string>& grid, int catJump, int mouseJump) {
        int m = grid.size(), n = grid[0].size();
        int total = m * n;

        int mouseStart = -1, catStart = -1, food = -1;

        auto id = [n](int r, int c) { return r * n + c; };

        // precompute valid cells and locate M, C, F
        vector<vector<bool>> valid(m, vector<bool>(n, false));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] != '#') {
                    valid[i][j] = true;
                    if (grid[i][j] == 'M') mouseStart = id(i, j);
                    if (grid[i][j] == 'C') catStart = id(i, j);
                    if (grid[i][j] == 'F') food = id(i, j);
                }
            }
        }

        // adjacency for mouse and cat moves
        vector<vector<int>> mouseMoves(total), catMoves(total);
        int dirs[5] = {0, 1, 0, -1, 0};

        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                if (!valid[r][c]) continue;
                int from = id(r, c);

                // staying in place is always allowed
                mouseMoves[from].push_back(from);
                catMoves[from].push_back(from);

                // four directions
                for (int d = 0; d < 4; ++d) {
                    int dr = dirs[d], dc = dirs[d + 1];

                    // mouse moves
                    for (int step = 1; step <= mouseJump; ++step) {
                        int nr = r + dr * step;
                        int nc = c + dc * step;
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) break;
                        if (!valid[nr][nc]) break;
                        mouseMoves[from].push_back(id(nr, nc));
                    }

                    // cat moves
                    for (int step = 1; step <= catJump; ++step) {
                        int nr = r + dr * step;
                        int nc = c + dc * step;
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) break;
                        if (!valid[nr][nc]) break;
                        catMoves[from].push_back(id(nr, nc));
                    }
                }
            }
        }

        // result[mouse][cat][turn] = 0 unknown, 1 mouse win, 2 cat win
        vector<vector<array<int,2>>> result(total, vector<array<int,2>>(total, {0,0}));
        // degree[mouse][cat][turn] = how many moves are available for current player
        vector<vector<array<int,2>>> degree(total, vector<array<int,2>>(total, {0,0}));

        for (int mp = 0; mp < total; ++mp) {
            for (int cp = 0; cp < total; ++cp) {
                degree[mp][cp][MOUSE_TURN] = (int)mouseMoves[mp].size();
                degree[mp][cp][CAT_TURN]   = (int)catMoves[cp].size();
            }
        }

        queue<tuple<int,int,int>> q; // (mouse, cat, turn)

        // terminal states initialization
        for (int pos = 0; pos < total; ++pos) {
            // positions where cell is valid
            // Mouse reaches food => mouse wins
            result[food][pos][MOUSE_TURN] = MOUSE_WIN;
            result[food][pos][CAT_TURN]   = MOUSE_WIN;
            q.emplace(food, pos, MOUSE_TURN);
            q.emplace(food, pos, CAT_TURN);

            // Cat at food or mouse and cat same => cat wins
            result[pos][food][MOUSE_TURN] = CAT_WIN;
            result[pos][food][CAT_TURN]   = CAT_WIN;
            q.emplace(pos, food, MOUSE_TURN);
            q.emplace(pos, food, CAT_TURN);

            result[pos][pos][MOUSE_TURN] = CAT_WIN;
            result[pos][pos][CAT_TURN]   = CAT_WIN;
            q.emplace(pos, pos, MOUSE_TURN);
            q.emplace(pos, pos, CAT_TURN);
        }

        auto getPrevStates = [&](int mouse, int cat, int turn) {
            // current state (mouse, cat, turn) is known.
            // find all previous states that could move into this one.
            vector<tuple<int,int,int>> prev;
            if (turn == MOUSE_TURN) {
                // it's mouse's turn now, so previous was cat's move
                for (int prevCat : catMoves[cat]) {
                    // previous state was (mouse, prevCat, CAT_TURN) and cat moved to 'cat'
                    if (result[mouse][prevCat][CAT_TURN] == 0)
                        prev.emplace_back(mouse, prevCat, CAT_TURN);
                }
            } else {
                // now cat turn, previous was mouse move
                for (int prevMouse : mouseMoves[mouse]) {
                    // previous state was (prevMouse, cat, MOUSE_TURN) and mouse moved to 'mouse'
                    if (result[prevMouse][cat][MOUSE_TURN] == 0)
                        prev.emplace_back(prevMouse, cat, MOUSE_TURN);
                }
            }
            return prev;
        };

        // retrograde BFS
        while (!q.empty()) {
            auto [mouse, cat, turn] = q.front();
            q.pop();
            int stateRes = result[mouse][cat][turn];

            for (auto &prevState : getPrevStates(mouse, cat, turn)) {
                int pm, pc, pt;
                tie(pm, pc, pt) = prevState;
                if (result[pm][pc][pt] != 0) continue;

                // if previous player can move into a state where it wins, it will choose it
                if ((stateRes == MOUSE_WIN && pt == MOUSE_TURN) ||
                    (stateRes == CAT_WIN   && pt == CAT_TURN)) {
                    result[pm][pc][pt] = stateRes;
                    q.emplace(pm, pc, pt);
                } else {
                    // otherwise, reduce degree; if all moves lead to opponent win, this is losing
                    if (--degree[pm][pc][pt] == 0) {
                        result[pm][pc][pt] = (pt == MOUSE_TURN ? CAT_WIN : MOUSE_WIN);
                        q.emplace(pm, pc, pt);
                    }
                }
            }
        }

        // if unresolved, by problem constraint (limit 1000 turns) cat eventually wins
        return result[mouseStart][catStart][MOUSE_TURN] == MOUSE_WIN;
    }
};
