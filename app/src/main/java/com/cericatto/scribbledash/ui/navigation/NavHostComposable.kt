package com.cericatto.scribbledash.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cericatto.scribbledash.ui.difficulty.DifficultyScreenRoot
import com.cericatto.scribbledash.ui.draw.DrawScreenRoot
import com.cericatto.scribbledash.ui.home.HomeScreenRoot

@Composable
fun NavHostComposable(
	modifier: Modifier = Modifier
) {
	val navController = rememberNavController()
	NavHost(
		navController = navController,
		startDestination = Route.HomeScreen
	) {
		composable<Route.HomeScreen> {
			HomeScreenRoot(
				onNavigate = { navController.navigate(it) },
				onNavigateUp = { navController.navigateUp() },
				modifier = modifier
			)
		}
		composable<Route.DifficultyScreen> {
			DifficultyScreenRoot(
				onNavigate = { navController.navigate(it) },
				onNavigateUp = { navController.navigateUp() },
				modifier = modifier
			)
		}
		composable<Route.DrawScreen> {
			DrawScreenRoot(
				onNavigate = { navController.navigate(it) },
				onNavigateUp = { navController.navigateUp() },
				modifier = modifier
			)
		}
	}
}