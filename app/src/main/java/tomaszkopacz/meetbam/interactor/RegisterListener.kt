package tomaszkopacz.meetbam.interactor

interface RegisterListener {

    fun registerSucceed()
    fun mailIsOccupied()
    fun registerFailed()
}