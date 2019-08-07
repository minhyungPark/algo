#include <iostream>
using namespace std;

void merge(int *arr,int *temp,int start,int end) {
    int mid = (start + end)/2;
    int idx = start;
    int idx1 = start;
    int idx2 = mid;
    while( idx1 < mid && idx2 < end){
        if(arr[idx1]<arr[idx2]){
            temp[idx++] = arr[idx1++];
        }else {
            temp[idx++] = arr[idx2++];
        }
    }
    while(idx1<mid){
        temp[idx++] = arr[idx1++];
    }
    while (idx2<end){
        temp[idx++] = arr[idx2++];
    }

    for(int i=start;i<end;++i){
        arr[i] = temp[i];
    }
}


void sort(int *arr,int *temp,int start,int end){
    int len = end - start;
    if(len == 1) return;
    if(len == 2) {
        if(arr[start]>arr[start+1]){
            int t = arr[start];
            arr[start] = arr[start+1];
            arr[start+1] = t;
        }
        return;
    }
    int mid = ( start + end )/2;
    sort(arr,temp,start,mid);
    sort(arr,temp,mid,end);
    merge(arr,temp,start,end);
}


int main() {
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N;
    cin >> N;
    int arr[N];
    int sArr[N];
    for(int i=0;i<N;++i){
        cin >> arr[i];
    }
    sort(arr,sArr,0,N);
    for(int i=0;i<N;++i){
        cout << arr[i]<<'\n';
    }

    return 0;
}