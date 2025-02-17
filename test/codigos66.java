#include <bits/stdc++.h>
#define x first
#define y second
#define pb push_back
#define mp make_pair
#define up_b upper_bound
#define low_b lower_bound
#define sz(x) (int)x.size()
#define all(v) v.begin(),v.end()
#define boost ios_base::sync_with_stdio(0),cin.tie(0),cout.tie(0)

using namespace std;

typedef long long ll;
typedef long double ld;
typedef pair<int,int> pii;
typedef pair<int,ll> pil;
typedef pair<ll,int> pli;
typedef pair<ll,ll> pll;

const ll INF=1e18;
const int inf = 2e9;
const ll mod = 1e8;
const ld eps=1e-7;
const ld pi = acos(-1);
const int dx[4]={0,0,1,-1};
const int dy[4]={1,-1,0,0};
void add(int &a,int b){
	a+=b;
	if(a>=mod)a-=mod;
}
const int N=2e5+11;
const ll M=2e5+1;
int a[N],l[N],r[N];
int t[4*N];

void push(int v){
	if(t[v]!=-1){
		t[v*2]=max(t[v*2],t[v]);
		t[v*2+1]=max(t[v*2+1],t[v]);
		t[v]=-1;
	}
}

void upd(int v,int tl,int tr,int l,int r,int val){
	if(l>r)return ;
	if(l==tl&&tr==r){
		t[v]=max(t[v],val);
		return ;
	}
	push(v);
	int tm=(tl+tr)/2;
	upd(v*2,tl,tm,l,min(r,tm),val);
	upd(v*2+1,tm+1,tr,max(l,tm+1),r,val);
}

int get(int v,int tl,int tr,int pos){
	if(tl==tr)return t[v];
	push(v);
	int tm=(tl+tr)/2;
	if(pos<=tm)return get(v*2,tl,tm,pos);
	else return get(v*2+1,tm+1,tr,pos);
}

int main(){
	int n;
	cin>>n;
	for(int i=1;i<=n;i++){
		cin>>a[i];
	}
	deque<int>d;
	for(int i=1;i<=n;i++){
		while(!d.empty()&&a[d.back()]>a[i]){
			r[d.back()]=i-1;
			d.pop_back();
		}
		d.pb(i);
	}
	while(!d.empty()){
		r[d.back()]=n;
		d.pop_back();
	}
	for(int i=n;i>=1;i--){
		while(!d.empty()&&a[d.back()]>a[i]){
			l[d.back()]=i+1;
			d.pop_back();
		}
		d.pb(i);
	}
	while(!d.empty()){
		l[d.back()]=1;
		d.pop_back();
	}
	for(int i=1;i<=4*n;i++){
		t[i]=-1;
	}
	for(int i=1;i<=n;i++){
		upd(1,1,n,1,r[i]-l[i]+1,a[i]);
	}
	for(int i=1;i<=n;i++){
		cout<<get(1,1,n,i)<<" ";
	}
}
