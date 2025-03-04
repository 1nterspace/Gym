package di

import data.repository.UserRepositoryImpl
import data.storage.RoomUserStorage
import data.storage.UserStorage
import domain.repository.UserRepository
import org.koin.dsl.module

val dataDi = module {

    single<UserStorage> {
        RoomUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }

}