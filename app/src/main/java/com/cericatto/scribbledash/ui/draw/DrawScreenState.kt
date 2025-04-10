package com.cericatto.scribbledash.ui.draw

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.cericatto.scribbledash.model.PathData
import com.cericatto.scribbledash.model.initOffsetList
import java.util.Stack

const val HISTORY_LIMIT = 5

data class DrawScreenState(
	val count: Int = -1,
	val selectedColor: Color = Color.Black,
	val currentPath: PathData? = null,
	val paths: List<PathData> = emptyList(),
//	val history: List<PathData> = emptyList(),
//	val slidingWindows: List<Int> = emptyList()
	val actionStack: Stack<PathData> = Stack()
)

fun initPathList(): List<PathData> {
	val move = PathData(
		path = initOffsetList()
	)
	return listOf(move)
}

fun initPathList(
	offsetList: List<Offset>
): List<PathData> {
	val data = PathData(
		path = offsetList
	)
	return listOf(data)
}