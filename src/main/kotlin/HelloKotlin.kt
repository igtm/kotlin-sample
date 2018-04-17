/**
 * Created by tomokatsuiguchi on 2018/04/17.
 */
import java.util.Scanner
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result

fun main(args: Array<String>) {
    println("Hello World!!")
    val input = getIn()
    println(input)
    // 非同期処理
    "http://api.openweathermap.org/data/2.5/weather?q=$input&appid=894417bd55cdd22c9093cd7e889a8648".httpGet().response { request, response, result ->
        when (result) {
            is Result.Success -> {
                // レスポンスボディを表示
                println("非同期処理の結果：" + String(response.data))
            }
            is Result.Failure -> {
                println("通信に失敗しました。")
            }
        }
    }
}

fun getIn(): String {
    print(">> ")
    val scanner = Scanner(System.`in`)
    return scanner.nextLine()
}