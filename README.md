# NewsAppAndroid

[NEWSAPI](https://newsapi.org)を使ったnews閲覧アプリ


|一覧画面|メニュー|ブラウザ画面|
|--|--|--|
|<img src="https://user-images.githubusercontent.com/50735539/149617753-64302720-7768-4a3f-a887-11a97c231194.png" width="200">|<img src="https://user-images.githubusercontent.com/50735539/149617826-2fa7c198-57fc-490c-956e-d08eb8657ec9.png" width="200">|<img src="https://user-images.githubusercontent.com/50735539/149617863-86648c08-91ab-4268-88db-daff087f95a3.png" width="200">|


## アーキテクチャ
MVVM

## セットアップ
[NEWSAPI公式サイト](https://newsapi.org)からAPIKeyを発行

`app/src/main/java/com/example/newsappandroid/data`に以下のデータクラスを追加

``` kotlin
data class Key(
    val newsApi: String = "YOUR_API_KEY"
)
```
`"YOUR_API_KEY"`に自分で発行したKeyを貼り付ける
