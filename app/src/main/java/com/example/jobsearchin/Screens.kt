package com.example.jobsearchin

sealed class Screens (val screen : String){
    data object Home: Screens("home")
    data object All_Jobs: Screens("all_jobs")
    data object My_Activity: Screens("my_activity")
    data object Loan: Screens("loan")
    data object Profile: Screens("profile")
}
