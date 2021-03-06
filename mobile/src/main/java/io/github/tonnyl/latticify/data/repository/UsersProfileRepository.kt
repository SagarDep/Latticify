package io.github.tonnyl.latticify.data.repository

import io.github.tonnyl.latticify.data.UsersProfileWrapper
import io.github.tonnyl.latticify.data.datasource.UsersProfileDataSource
import io.github.tonnyl.latticify.retrofit.RetrofitClient
import io.github.tonnyl.latticify.retrofit.service.UsersProfileService
import io.reactivex.Observable

/**
 * Created by lizhaotailang on 09/10/2017.
 */
class UsersProfileRepository : UsersProfileDataSource {

    private val mUsersProfileService = RetrofitClient.createService(UsersProfileService::class.java)
    private val mToken = RetrofitClient.mToken

    override fun getUsersProfile(includeLabels: Boolean, userId: String): Observable<UsersProfileWrapper> {
        return mUsersProfileService.getUsersProfile(mToken, includeLabels, userId)
    }


    override fun setUsersProfile(name: String?, profile: String?, userId: String?, value: String?): Observable<UsersProfileWrapper> {
        return mUsersProfileService.setUsersProfile(mToken, name, profile, userId, value)
    }


}
