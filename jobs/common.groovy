println(message)

n.each {
    def myJob = freeStyleJob('SimpleJob')
    myJob.with {
        description 'A Simple Job'
    }
}