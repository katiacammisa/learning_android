package com.austral.learning_android.tabs.data

import com.austral.learning_android.navigation.LearningAndroidScreen

val items = listOf(
    ListItem(
        LearningAndroidScreen.Basics.name,
        category = ListItemCategory.Initial,
    ),
    ListItem(
        LearningAndroidScreen.ViewModels.name,
        category = ListItemCategory.Initial,
    ),

    ListItem(
        LearningAndroidScreen.Texts.name,
    ),
    ListItem(
        LearningAndroidScreen.Buttons.name,
    ),
    ListItem(
        LearningAndroidScreen.Columns.name,
    ),
    ListItem(
        LearningAndroidScreen.Rows.name,
    ),
    ListItem(
        LearningAndroidScreen.Cards.name,
    ),
    ListItem(
        LearningAndroidScreen.Icons.name,
    ),
    ListItem(
        LearningAndroidScreen.Chips.name,
    ),
    ListItem(
        LearningAndroidScreen.Switches.name,
    ),
    ListItem(
        LearningAndroidScreen.Tabs.name,
    ),
    ListItem(
        LearningAndroidScreen.FABs.name,
    ),
    ListItem(
        LearningAndroidScreen.Checkboxes.name,
    ),
    ListItem(
        LearningAndroidScreen.Images.name,
    ),
)

data class ListItem(
    val title: String,
    val category: ListItemCategory = ListItemCategory.Basic,
)

enum class ListItemCategory {
    Initial,
    Basic,
}