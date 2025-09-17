bool helper(const char* s, const char* p, int i, int j, int n, int m) {
    if (i == n && j == m) return true;
    if (j == m) return false;

    bool first = false;
    if (i < n && j < m && (s[i] == p[j] || p[j] == '.')) {
        first = true;
    }

    bool take = false;
    bool skip = false;
    bool normal = false;

    if (j + 1 < m && p[j + 1] == '*') {
        skip = helper(s, p, i, j + 2, n, m);
        if (i < n && j < m && (s[i] == p[j] || p[j] == '.')) {
            take = first && helper(s, p, i + 1, j, n, m);
        }
    } else {
        normal = first && helper(s, p, i + 1, j + 1, n, m);
    }

    return normal || take || skip;
}

bool isMatch(const char* s, const char* p) {
    int n = strlen(s);
    int m = strlen(p);
    return helper(s, p, 0, 0, n, m);
}