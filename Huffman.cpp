#include <iostream>
#include <algorithm>
#include <queue>
#include <map>
using namespace std;

struct node
{
    int freq;
    char sym;
    node *left = NULL, *right = NULL;
    friend bool operator <(node a, node b)
    {
        return a.freq > b.freq;
    }
};

node a[100];
priority_queue <node> p;
map <char, string> m;

void print(node *temp, string code)
{
    if ((*temp).left == NULL || (*temp).right == NULL)
    {
        m[(*temp).sym] = code;
        return;
    }
    print((*temp).left, code + "0");
    print((*temp).right, code + "1");
}

int main()
{
    int n;
    cin >> n;
    for (int i = 0; i < n; ++i)
    {
        cin >> a[i].sym >> a[i].freq;
        p.push(a[i]);
    }

    while (p.size() > 1)
    {
        node q, a;
        q.left = new node;
        q.right = new node;

        a = p.top();
        (*q.left).freq = a.freq;
        (*q.left).sym = a.sym;
        (*q.left).left = a.left;
        (*q.left).right = a.right;
        p.pop();

        a = p.top();
        (*q.right).freq = a.freq;
        (*q.right).sym = a.sym;
        (*q.right).left = a.left;
        (*q.right).right = a.right;
        p.pop();

        q.freq = (*q.left).freq + (*q.right).freq;
        p.push(q);
    }
    node head = p.top();
    print(&head, "");

    for (int i = 0; i < n; ++i)
        cout << a[i].sym << " = " << m[a[i].sym] << endl;
    return 0;
}
