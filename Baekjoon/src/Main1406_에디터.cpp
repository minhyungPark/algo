#include <iostream>
using namespace std;

struct Node{
    char data;
    int prev;
    int next;
};

struct List{
    Node *nList;
    int head;
    int tail;
    int pos;
    int target;

    List( int n ) {
        int tmp = n+100000+2;
        nList = new Node[n+100000+2];
        head = tmp-2;
        tail = tmp-1;
        pos = 0;
        target = 0;
        nList[head].next = tail;
        nList[tail].prev = head;
    }

    void pushBack(char c){
        int prev = nList[tail].prev;
        int next = tail;
        nList[pos].data = c;
        nList[pos].prev = prev;
        nList[pos].next = next;

        nList[next].prev = pos;
        nList[prev].next = pos;

        pos++;
        target = next;
    }

    void push(char c){
        int prev = nList[target].prev;
        int next = target;

        nList[pos].data = c;
        nList[pos].prev = prev;
        nList[pos].next = next;

        nList[next].prev = pos;
        nList[prev].next = pos;

        pos++;
    }
    void erase() {
        if( nList[target].prev == head) return;
        int prev = nList[nList[target].prev].prev;
        int next = target;

        nList[prev].next = next;
        nList[next].prev = prev;
    }

    void leftGo() {
        if(nList[target].prev == head) return;
        target = nList[target].prev;
    }
    void rightGo() {
        if(target == tail) return;
        target = nList[target].next;
    }

    void print() {
        int next = nList[head].next;
        while(next != tail) {
            cout<<nList[next].data;
            next = nList[next].next;
        }
    }
};
int main() {
    ios_base :: sync_with_stdio(false); 
    cin.tie(NULL);
    cout.tie(NULL);
    char str[100001];
    cin >> str;
    int N;
    cin >> N;
    List list(N);
    for(int i=0;str[i]!='\0';++i){
        list.pushBack(str[i]);
    }
    for(int i=0;i<N;++i){
        char cmd;
        cin >> cmd;
        if(cmd == 'L'){
            list.leftGo();
        }else if(cmd == 'D'){
            list.rightGo();
        }else if(cmd == 'B'){
            list.erase();
        }else if(cmd == 'P'){
            char temp;
            cin >> temp;
            list.push(temp);
        }
    }
    list.print();

    return 0;
}