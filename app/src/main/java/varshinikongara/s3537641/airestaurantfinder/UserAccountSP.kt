package varshinikongara.s3537641.airestaurantfinder

import android.content.Context

object UserAccountSP {

    private const val USERDETAILS_PREF = "AIRestaurantFinder"

    fun saveULS(currentActivity: Context, value: Boolean) {
        val userLoginSP = currentActivity.getSharedPreferences(USERDETAILS_PREF, Context.MODE_PRIVATE)
        val editor = userLoginSP.edit()
        editor.putBoolean("LOGIN_STATUS", value).apply()
    }

    fun getULS(currentActivity: Context): Boolean {
        val userLoginSP = currentActivity.getSharedPreferences(USERDETAILS_PREF, Context.MODE_PRIVATE)
        return userLoginSP.getBoolean("LOGIN_STATUS", false)
    }

    fun putName(currentActivity: Context, name: String) {
        val userName = currentActivity.getSharedPreferences(USERDETAILS_PREF, Context.MODE_PRIVATE)
        val editor = userName.edit()
        editor.putString("USER_NAME", name).apply()
    }

    fun fetchName(currentActivity: Context): String? {
        val userName = currentActivity.getSharedPreferences(USERDETAILS_PREF, Context.MODE_PRIVATE)
        return userName.getString("USER_NAME", null)
    }

    fun putPlace(currentActivity: Context, gender: String) {
        val userGender = currentActivity.getSharedPreferences(USERDETAILS_PREF, Context.MODE_PRIVATE)
        val editor = userGender.edit()
        editor.putString("USER_PLACE", gender).apply()
    }

    fun fetchPlace(currentActivity: Context): String? {
        val userGender = currentActivity.getSharedPreferences(USERDETAILS_PREF, Context.MODE_PRIVATE)
        return userGender.getString("USER_PLACE", null)
    }


    fun putEmail(currentActivity: Context, email: String) {
        val userEmail = currentActivity.getSharedPreferences(USERDETAILS_PREF, Context.MODE_PRIVATE)
        val editor = userEmail.edit()
        editor.putString("USER_EMAIL", email).apply()
    }

    fun fetchEmail(currentActivity: Context): String? {
        val userEmail = currentActivity.getSharedPreferences(USERDETAILS_PREF, Context.MODE_PRIVATE)
        return userEmail.getString("USER_EMAIL", null)
    }
}
