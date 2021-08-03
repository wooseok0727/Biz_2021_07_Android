# LinearLayout
* Andorid 탄생 초기부터 사용되어온 전통적인 Layout view
* 가로방향, 세로방향을 지정하여 내부의 view들을 간편하개 배치할때 사용하는 layout
* android:orientation을 지정하여 horizontal ,vertical 로 설정하면 포함된
view들이 수평, 수직으로 나열되는 구조를 갖는다

* android: weight 를 지정하여 포함된 view들을 일정한 비율로 배치를 할수 있다.

# RecyclerView
* android에서 데이터들(data list)를 표현하는 대표적인 RecyclerView
* 현재 화면에 보이는 view는 1page 짜리 view 인데
데이터가 연속적으로 존재할 경우에는 자동적으로 전체 Data List를
불러오고 보여주는 코드가 내부에서 작동되는 구조이다

## RecyclerView.Adapter 상속 클래스 생성
* 표현하고자 하는 Data와 화면에 보여줄 View를 연결하는 Helper 도구

## RecyclerView.ViewHolder 상속 클래스 생성
* 데이터들을 표현할때  각각의 item을 화면에 그리는 도구

## item view layout 파일 생성
* RecyclerView에서 필요한 화면 구성요소를 만들 Layout 파일
* 표현하고자하는 데이터가 10개이다 라고하면 각각에 item 들은 공통된
모양으로 그려질 것이다
* 이때 공통된 각 Item을 그려낼 layout을 만드는 과정