package com.bliitz.app.global_ui.config_activity

import android.graphics.Color

enum class ToolbarIcon {
    BELL, NONE
}

enum class ToolbarTint {
    WHITE, DARK, NONE
}

enum class SystemBarColor {
    WHITE, DARK
}

interface BaseActivity {
    fun updateToolbarIcon(icon: ToolbarIcon)
    fun updateSystemBarColor(tint: SystemBarColor)
    fun updateToolbarColor(tint: ToolbarTint)
    fun updatebottomNavigationVisibility(hasBottomNavigation: Boolean)
    fun updateToolbarVisibility(hasToolbar: Boolean)
    fun updateToolbarTitle(title: String)
    fun updateToolbar(hasBackButton: Boolean)
}