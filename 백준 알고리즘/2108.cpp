#include <iostream>
#include <cmath>

#define MAX_RANGE 8001

using namespace std;

int main (void) {
  int N;     // 숫자들의 개수
  cin >> N;
  
  int maxNumber = -4000;
  int minNumber = 4000;
  double sum = 0;
  int number;
  int numCount[MAX_RANGE] = {0, };
  
  // 입출력 성능 향상
  cin.tie(NULL);
  ios_base::sync_with_stdio(false);
  
  for (int i = 0 ; i < N; i++) {
    cin >> number;
    // 최빈값을 구하기위해 숫자들의 개수를 센다
    numCount[number + MAX_RANGE / 2]++;
    
    // 평균을 구하기 위해 모든 숫자들의 합을 구한다.
    sum += number;
    
    // 범위를 구하기위해 최댓값과 최솟값을 구한다.
    // 최댓값을 구한다
    if (maxNumber < number) {
      maxNumber = number;
    }
    // 최솟값을 구한다.
    if (minNumber > number) {
      minNumber = number;
    }
  }
  
  // 범위 구해서 저장
  int range = maxNumber - minNumber;
  // 평균 구해서 저장
  int average = round(sum / N);
  // 최빈값 구해서 저장
  int mode = 0;     // 최빈값 저장 변수
  int minMode = MAX_RANGE;  // 최빈값 중 가장 작은 수 저장
  int minMode2 = MAX_RANGE; // 최빈값 중 두번째로 작은 수 저장

  for (int i = 0 ; i < MAX_RANGE; i++) {
    // 최빈값을 구한다
    if (numCount[mode] < numCount[i]) {
      mode = i;
    }
  }

  // 최빈값 중에서 가장 작은 최빈값을 구한다
  for (int i = 0; i < MAX_RANGE; i++) {
    if(numCount[mode] == numCount[i] && minMode > i) {
      minMode = i;
    }
  }
  // 최빈값 중에서 두번째로 작은 최빈값을 구한다.
  for (int i = 0 ; i < MAX_RANGE; i++) {
    if (numCount[mode] == numCount[i] && minMode2 > i && i > minMode) {
      minMode2 = i;
    }
  }

  // 만약 최빈값이 한개라면 
  if (minMode2 == MAX_RANGE) {
    // 구한 최빈값 선택
    mode = mode - MAX_RANGE / 2;
  }
  // 최빈값이 두 개 이상이라면  
  else {
    // 최빈값 중 두번째로 작은 값 선택
    mode = minMode2 - MAX_RANGE / 2;
  }
  // 중간값 구해서 저장
  int count = 0;
  int median = 0;
  for (int i = 0; i < MAX_RANGE; i++) {
    // 자료의 개수가 홀수이므로
    // N/2번째 인덱스가 중앙값이 된다
    while (numCount[i] > 0) {
      if (count == N / 2) {
        median = i - MAX_RANGE / 2;
      }
      count++;
      numCount[i]--;
    }
  }
  
  // 산술평균, 중앙값, 최빈값, 범위를 출력한다.
  cout << average << '\n';
  cout << median << '\n';
  cout << mode << '\n';
  cout << range << '\n';
  
}
