package com.moulik.jenkins;

/**
 * Jenkins Pipeline Tutorial | CI/CD Pipeline Jenkins | Jenkins Tutorial | DevOps Training | Edureka
 * https://www.youtube.com/watch?v=_fmX31VFbL8
 * 
 * Ques: Why do we need Continuous Delivery?
 * Developers commit the code to the repo and then QA would test those, after which it is deployed to Prod. The application
 * fails to load in the Prod envt. The possible reasons for the same could be:
 *  1. Different environments (servers)
 *  2. Different libraries and packages (dependencies)
 *  3. End user load (traffic): Every server has a threshold beyond which it is not able to process anymore user requests.
 *  4. App not accessible to intended audience
 *  
 * These problems can be solved by a CD pipeline. A pipeline has some modules.
 * 1. Commit module: The code/changes that you commit are stored in a VCS like Git. A VCS is a system that helps you track
 * your changes over a period of time. A VCS is very helpful because since it tracks your changes, it can help go to the old
 * changes if some new changes are breaking the application.
 * 2. Build Module (UT/IT): Here we implement CI using tools like Jenkins. CI is the process which makes sure that with 
 * every integration of code, as soon as it is committed, it should be pulled, built and tested using automation tools. This
 * helps in making sure that less errors arise later in the software cycle.
 * 3. Test Environment (Acceptance Testing/Load Testing): This stage makes sure that application is always in a production-
 * ready state. 
 * Load Testing is the testing performed to check the behavior of the application under certain expected load. This solves 
 * the 3rd problem of End user load traffic. 
 * Acceptance Testing is the testing which is used to tell that users can access the application without any problems. Even
 * when there is problem with the application, immediate feedback can be given to the developers so that they can make 
 * remediating changes. This solves the 4th problem.
 * 
 * Advantages of Continuous Delivery:
 * 	Automates software releases
 * 	Increases Developer Productivity
 * 	Locates and address bugs quicker
 *  
 * CD is a practice to continuously (anytime) release software. Code changes are continuously built, tested and pushed to a
 * non-production environment by using automated tools. Software delivery cycles are more rapid and effective.
 * 
 * HP used CICD pipeline to improve their productivity.
 * 
 * The features that existed Before Jenkins Pipeline:
 * Jenkins build flow
 * Jenkins Build Pipeline Plugin
 * Jenkins Workflow
 * 
 * These plugins represented multiple Jenkins jobs as one pipeline. These pipelines are a collection of jenkins jobs which
 * trigger each other in a specific sequence.
 * 	Job 1 -> Building, Job 2 -> Testing, Job 3 -> Deployment 
 * Chain these jobs together and run using build pipeline plugin (Better for small deployment)
 * 
 * Limitations: 
 * 1. Complex pipelines are hard to implement
 * 2. The maintenance cost is huge and increases with the number of processses
 * 3. Tedious to build and manage such a vast number of jobs.
 * 
 * To mitigate these limitations, Jenkins Pipeline was introduced. Jenkins Pipeline is a single platform that runs the 
 * entire pipeline as code.
 * All the standard jobs defined by Jenkins are manually written in one script and they can be stored in a VCS.
 * Instead of building several jobs for each phase, you can now code the entire workflow and put it in a jenkins file.
 * 
 * Key Features of Jenkins Pipeline:
 * 1. Pipeline as code
 * 2. Code can be checked into a VCS
 * 3. Incorporates user input
 * 4. Restart from saved checkpoint
 * 5. Run jobs in parallel
 * 6. Integrate with other plugins such as Git, Docker etc.
 * 7. Allows conditional loops (for, when etc)
 * 
 * Jenkinsfile
 * 	A text file that stores the pipeline as code
 * 	It can be checked into an SCM on your local system
 * 	Enables the developers to access, edit and check the code at all times
 * 	It is written in Groovy DSL
 * 	Written based on 2 syntaxes: Declarative Pipeline and Scripted Pipeline
 * 
 * Declarative Pipeline
 * Recent feature
 * Simpler groovy syntax
 * Code is written locally in a file and is checked into SCM
 * Code is defined within a 'pipeline block': A user defined block that contains all the stages.
 * 
 * Scripted Pipeline
 * Traditional way of writing the code
 * Stricter groovy syntax
 * Code is written on the Jenkins UI instance
 * The code is defined within a 'node' block: A node is a machine that executes the entire workflow.
 * 
 * Pipeline Concepts
 * 1. Agent: a directive which instructs Jenkins to allocate an executor for the builds. It is defined for either an entire
 * 	pipeline or a specific stage.
 * 	It has the following parameters:
 * 		Any: runs pipeline/stage on any available agent
 * 		None: applied at the root of the pipeline, it indicates that there is no global agent and each stage must specify
 *			its own agent
 *		Label: Executes the pipeline/stage on the labeled agent.
 *		Docker: Uses docker container as an execution environment for the pipeline or a specific stage.
 *
 * 2. Stages: It contains all the work, each stage performs a specific task.
 * 
 * 3. Steps: Steps are carried out in a sequence to execute a stage.
 * 
 * Create a Jenkins Pipeline
 * 1. Click on new Item and select Pipeline and give name like "Pipeline_demo"
 * 2. Select the Pipeline project and click Ok.
 * 3. Select Definition: Pipeline script from SCM
 * 4. Enter SCM details like GIT, Repo URL and then Script Path and click Apply and Save.
 * 
 * 	
 * 
 *
 */
public class JenkinsPipelines {

}
