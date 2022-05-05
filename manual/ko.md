# <div align="center">KDM 메뉴얼</div>
```KDM```어플은 집의 제어를 스마트폰으로 가능케 하도록 만들어진 프로그램입니다.  
  
이 메뉴얼에는 이 프로젝트와 앱에 관한 모든 설명들을 최대한 자세하게 담으려고 노력했습니다.

## 0. 왜 이름이 KDM인가요?
```KDM```프로젝트는 이른 아침에 출근/등교하는 사람들을  위해 알람 - 기상 보조 - 점등 - 보일러 가동 - ... - 퇴근 후 점등까지를 작동시키는 프로그램으로서 
쉽게 말하자면, 현대인들의 아침을 뜻하는 ```M```orning과 단국대학교의 ```D```an, 시제품의 구성 아두이노 조립에 큰 도움을 준 ```K```CK학생의 이니셜을 모아
```KDM```어플리케이션이 되었습니다.

## 1. 쓸만한 기능들
<img src="https://github.com/reane0809/Mid-Term-Project/blob/main/manual/img/main_1.png" width="150" height="300"></img>
<img src="https://github.com/reane0809/Mid-Term-Project/blob/main/manual/img/main_2.png" width="150" height="300"></img>
<img src="https://github.com/reane0809/Mid-Term-Project/blob/main/manual/img/main_3.png" width="150" height="300"></img>
<img src="https://github.com/reane0809/Mid-Term-Project/blob/main/manual/img/main_4.png" width="150" height="300"></img>
<img src="https://github.com/reane0809/Mid-Term-Project/blob/main/manual/img/main_5.png" width="150" height="300"></img>   
```KDM``` 앱(이하 ```KDM```)은 사물관리 외에도 여러가지 기능들이 구현되어있습니다.   
1. 날씨
2. 대중교통 (실시간 버스API 구현중)
3. 사용자 메모
4. 뉴스 헤드라인
5. 알람   

## 2. 사물 인터넷 연결
<div align="center"><img src="https://github.com/reane0809/Mid-Term-Project/blob/main/manual/img/LoB-A.PNG" width="434" height="400"></img></div>    

```KDM```을 이용하기 위해서는 스마트폰의 ```블루투스``` 기능을 활성화 한 후, ```KDM```을 실행하여 IoT가구들과의 연결이 가능합니다.     
연결이 완료되면 화면 하단에 연결 확인 메세지가 출력되며, 이후 사용자의 필요에 맞게 사용이 가능합니다.

## 3. 날씨, 뉴스, 사용자 메모
```KDM```은 사용자의 위치 정보 및 설정 위치 정보에 기반한 공공API를 사용합니다.   
이로 인해 미리 크롤링 된 데이터들을 아무 지연시간 없이 바로 확인이 가능하며, 현재까지 사용된 공공 API의 종류로는 기상청, 지하철, 뉴스가 있습니다.   

사용 설정 방법으로는 ```KDM``` 실행 후 우측 상단의 톱니바퀴 모양을 클릭하여 거주지/출근지, 알람시간, 지하철역 설정, (IoT)기능설정 중 원하는 설정에 들어가 주소 및 시간 설정으로
사용합니다.

사용자 메모의 경우, 메인 화면에서 즉시 설정, 수정이 가능합니다.

## 4. IoT 동작 순서 및 영상 메뉴얼
사용자 설정에 따라 맞춰진 시각에 알람이 울리게 되면, 사용자가 기상 후 침대에서 나오기 전까지 침대가 진동하여 사용자를 깨워줍니다.   
동시에 집안의 led 등과 연결된 센서가 작동하여 집 내부의 불을 점등하며 보일러를 작동하여 욕조에 물을 채워줍니다.   
욕조에 물이 일정 높이에 도달하게 되면 자동으로 보일러와 수도를 닫습니다.    
이후 외출 준비가 끝난 사용자가 현관을 지나 나가게 되면 모션 센서가 이를 감지하고 집 내부를 소등합니다.    

사용자가 복귀하면, 다시 센서를 통해 집 내부를 점등합니다.    


https://user-images.githubusercontent.com/57868072/166886146-49b48fb2-8813-4319-8191-b83eb10c686d.mp4


## 5. 알려진 문제점들
• 초기 기획당시 버스, 지하철 데이터의 실시간 확인이 목표였으나, 현재 XML서버에 접근하지 못하는 문제가 생겨 처리 중입니다.
![그림1](https://user-images.githubusercontent.com/57868072/166886760-0ace8c17-622c-44e6-b3f1-5401d832a206.png)    

~~• 아두이노와 안드로이드 사이의 통신을 위한 블루투스 모듈(HC-06)을작동하는 과정에서 스마트폰-모듈간의 통신이 정상적으로 연결되지 않는 경우가 빈번하게 발생(코드 최적화 완료)~~

![image](https://user-images.githubusercontent.com/57868072/166887300-484487c2-218e-4113-bfd2-ea4bbf423b6d.png)
    
    
    
##### Contact) <reane0809@gmail.com>
