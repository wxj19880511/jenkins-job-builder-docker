//git describe --tags `git rev-list --tags --max-count=1`

// println "ls | xargs echo".execute().text

def p = 'ls'.execute() | 'grep usr'.execute()
p.waitFor()
println p.text

def q = "git ls-remote --tags https://github.com/wxj19880511/jenkins-job-builder-docker.git".execute() | "awk -F'/' '{print \$3}'".execute() | "head -n 1".execute()
q.waitFor()
println q.text


folder('TEST_FOLDER') {
    
    description('Folder containing all QA jobs for project A')

    views {
        listView("TEST_VIEW") {
            description('All unstable jobs for project A')
            filterBuildQueue()
            filterExecutors()

            jobs {
                name('5G18A-QT')
                regex(/5G18A-.+-QT/)
            }

            columns {
                status()
                weather()
                name()
                lastSuccess()
                lastFailure()
                lastDuration()
                buildButton()
            }
        }
    }
}

job('TEST_FOLDER/5G18A-4.8-QT') {
    logRotator(-1, 10)
    jdk('Java 6')
}

multibranchPipelineJob('TEST_FOLDER/5G18A-4.20012-QT') {
    description('QT jobs for stream 4.20012')

    branchSources {
        git {
            remote('https://github.com/wxj19880511/jenkins-job-builder-docker.git')
            credentialsId('github')
            includes('*')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(5)
        }
    }

    configure {
        it / factory(class: "org.jenkinsci.plugins.workflow.multibranch.WorkflowBranchProjectFactory") << {
            // pipeline jobs will have their script path set to `pipelines/customPipeline.groovy`
            scriptPath("workflows/jenkinsfile")
        }

        it / sources / data / 'jenkins.branch.BranchSource' / source / traits << {
            'jenkins.plugins.git.traits.BranchDiscoveryTrait' {}
            'jenkins.plugins.git.traits.TagDiscoveryTrait' {}
        }

        it / 'sources' / 'data' / 'jenkins.branch.BranchSource'/ strategy(class: 'jenkins.branch.DefaultBranchPropertyStrategy') {
            properties(class: 'java.util.Arrays$ArrayList') {
                a(class: 'jenkins.branch.BranchProperty-array'){
                'jenkins.branch.NoTriggerBranchProperty'()
                }
            }
        }
    }
 
}

folder('TEST_FOLDER/f1') {
    
    description('Folder containing all QA jobs for project A')
}

folder('TEST_FOLDER/f1/f2') {
    
    description('Folder containing all QA jobs for project A')
}