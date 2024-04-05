package ru.zxtole.leetcode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.zxtole.leetcode.solutions.LongestCommonPrefix
import ru.zxtole.leetcode.solutions.RomainInteger
import ru.zxtole.leetcode.ui.theme.LeetcodeTheme

private const val romainRepresentation: String = "MMCDXXV"// 1996
//private const val romainRepresentation: String = "MCMXCVI"// 1996
//private const val romainRepresentation: String = "MMMCDXC"// 3490
//private const val romainRepresentation: String = "MMMXLV"// 3045
//private const val romainRepresentation: String = "MMCDXXV"// 2425
//private const val romainRepresentation: String = "MCDLXXVI"// 1476
//private const val romainRepresentation: String = "MMCCCXCIX"// 2399
//private const val romainRepresentation: String = "MCDLXXVI"// 1476
//private const val romainRepresentation: String = "MMCCCXCIX"// 2399
//private const val romainRepresentation: String = "MCDLXXVI"// 1676
//private const val romainRepresentation: String = "MCMXCIV"// 1994
//private const val romainRepresentation: String = "LVIII"//58
//private const val romainRepresentation: String = "MCMXCVI"//1996
//private const val romainRepresentation: String = "DCXXI" //621
//private const val romainRepresentation: String = "MDCCCLXXXIV" //1884
//private const val romainRepresentation: String = "IX" //9


class MainActivity : ComponentActivity() {
    private val intRepresentation: Int = romanToInt()

    private fun romanToInt(): Int {
        val romainIntegerSolution = RomainInteger()
        return romainIntegerSolution.romanToInt(romainRepresentation)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LeetcodeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Row {
                            RomainIntegerComposable(
                                romainRepresentation,
                                intRepresentation.toString(),
                                Modifier.padding(12.dp))
                        }

                        Row {
                            LongestCommonPrefixComposable(Modifier.padding(12.dp))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RomainIntegerComposable(romainIntegerAsString: String, romainIntegerAsInt: String,
                            modifier: Modifier = Modifier) {
    Text(
        text = "$romainIntegerAsString ->> $romainIntegerAsInt",
        modifier = modifier
    )
}

@Composable
fun LongestCommonPrefixComposable(modifier: Modifier = Modifier) {
    val strings = arrayOf("flower","flow","flight")
//    val strings = arrayOf("cir","car")
    val longestCommonPrefix = LongestCommonPrefix()
    val commonPrefix = "\"flower\",\"flow\",\"flight\" common prefix: \'" +
//    val commonPrefix = "\"cir\",\"car\" common prefix: \'" +
            longestCommonPrefix.longestCommonPrefix(strings) + "\'"
    Text(
        text = commonPrefix,
        modifier = modifier
    )
}