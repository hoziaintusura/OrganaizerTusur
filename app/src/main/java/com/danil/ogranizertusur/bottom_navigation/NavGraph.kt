package com.danil.ogranizertusur.bottom_navigation

import com.danil.ogranizertusur.workspace.screens.add_edit_notes.AddNoteScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.danil.ogranizertusur.R
import com.danil.ogranizertusur.news.screens.news.NewsInfo
import com.danil.ogranizertusur.news.screens.NewsScreen
import com.danil.ogranizertusur.news.screens.calendar_events.EventInfo
import com.danil.ogranizertusur.schedule.screens.ScheduleViewModel
import com.danil.ogranizertusur.schedule.screens.TabDaysOfWeek
import com.danil.ogranizertusur.settings.SettingsScreen
import com.danil.ogranizertusur.workspace.screens.notes.AddActivity
import com.danil.ogranizertusur.workspace.viewmodel.AddActivityViewModel


@Composable
fun NavGraph(
    navHostController: NavHostController,
    addViewModel: AddActivityViewModel,
    scheduleViewModel: ScheduleViewModel,
) {
    NavHost(navController = navHostController, startDestination = "schedule") {

        composable("schedule") {

            TabDaysOfWeek(scheduleViewModel)
        }

        composable("workspace") {
            AddActivity(
                addViewModel = addViewModel,
                onClickNote = {
                    navHostController.navigate("addNote")
                },
                onClickAddNote = {
                    navHostController.navigate("addNote")
                }
            )
        }
        composable("deadline") {
            Image(
                painter = painterResource(id = R.drawable.fon),
                contentDescription = "fon3",
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.7f),
                contentScale = ContentScale.FillBounds
            )
            TabDaysOfWeek(scheduleViewModel)
        }

        composable("news") {
            NewsScreen(onClickNews = {
                navHostController.navigate("newsInfo")
            }, onClickEvent = {
                navHostController.navigate("eventInfo")
            })
        }

        composable("addNote") {
            AddNoteScreen(
                addViewModel,
                onClickClose = {
                    navHostController.popBackStack()
                })
        }
        composable("newsInfo") {
            NewsInfo(onClickClose = {
                navHostController.popBackStack()
            })
        }
        composable("eventInfo") {
            EventInfo(onClickClose = {
                navHostController.popBackStack()
            })
        }
        composable("settings"){
            SettingsScreen()
        }
    }
}