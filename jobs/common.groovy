println(message)


def myJob = freeStyleJob('DSL/SimpleJob')
myJob.with {
    description 'A Simple Job'
}
