## ページ遷移

- 別の画面に移動した用に見えるのは実は上に別の画面がかぶさっているだけでページ遷移ではない
- Intentクラスを用いて画面（Activity）の起動をおこなう

以下の流れを踏む

- Intentクラスのインスタンスを生成
- 起動先アクティ日地に渡すデータを格納
- アクティビティを起動

1.Intentクラスのインスタンスを生成
第1引数：Context
第2引数：cls:Class(Java化したもの)

第1引数
this@MainActivity

第2引数
Kotlinのクラス 
クラス名::class

Java化した場合
クラス名::class.java

2.起動先アクティ日地に渡すデータを格納

putExtra()メソッドを利用する。

3.アクティビティを起動

startActivity()メソッドを利用


## Onclick属性

リスナを使わずに使う方法がある。android:onClick属性。
これをActivityから同じ名前で呼ぶことができる。
以下のルールに注意する

- publickメソッド
- 戻り値なし
- 引数はView型ひとつのみ

## 戻るボタン

finish()で表現している
実際はActivityを終了させている

