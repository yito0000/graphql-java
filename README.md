# graphql-java

### 実行手順
DBサーバ用意
```
docker-compose up -d
```

APサーバ起動
```
gradle bootRun
```

### 動作確認
以下のリンクを開く
http://localhost:9000/graphiql

GraphiQLの画面が表示されたら次を入力して実行
```
{
  cityById(id: 1) {
    ID
    Name
    District
    CountryCode
    Population
  }
}
```

期待結果
```
{
  "data": {
    "cityById": {
      "ID": "1",
      "Name": "Kabul",
      "District": "Kabol",
      "CountryCode": "AFG",
      "Population": "1780000"
    }
  }
}
```
