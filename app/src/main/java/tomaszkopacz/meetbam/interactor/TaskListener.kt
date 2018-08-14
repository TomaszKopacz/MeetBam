package tomaszkopacz.meetbam.interactor

interface TaskListener {

    fun onSucceed()
    fun onFailed()
}