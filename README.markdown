## This repository is deprecated and is being archived in the spring-attic

## Welcome!

This repository contains mini projects reproducing issues logged in Spring Web Flow's [issue tracker](https://jira.springsource.org). There are many reasons why this is prefered over .zip or patch file attachments:

* A streamlined process for evaluating issues so more bugs get fixed more quickly!
* Two-way communication with the Spring Web Flow team based on working code.
* A set of template projects to choose from.
* Improved code sharing across the Spring Web Flow team.
* A valuable archive of Spring Web Flow projects across a wide range of use cases and features.

All around a better way of interacting with the Spring Web Flow team.


## Log the issue

1. First, search [SWF JIRA](https://jira.springframework.org/browse/SWF) to see if your issue has already been reported as there may already be a reproduction issue in this repository!
1. If the issue doesn't exist, [create a new one](https://jira.springsource.org/secure/CreateIssue!default.jspa)

You now have a JIRA issue id such as "SWF-1502". Make note of this, as you'll need it below when creating your project.


## Demonstrate the issue

Assuming you've encountered and created an issue in the core Spring Web Flow project, you can now add a project to demonstrate it. 

### First-time setup

1. [Create a Github account](https://github.com/signup/free) if you don't already have one
1. [Fork this repository and clone it locally](https://help.github.com/fork-a-repo/)

### Create a project that reproduces your issue

The idea is to create the smallest possible project to demonstrate the issue.  The project is built with Maven and must contain only sources, XML and other necessary text files. No JARs, please!

For the purpose of these instructions, we'll assume your new JIRA issue ID is "SWF-1502"

#### Steps

1\. In your local clone of this repository, create a copy of the appopriate template sub-directory. Their names start with `SWF-0000`.

For example:

```bash
$ cd spring-webflow-issues
$ ./create-repro-project.sh SWF-0000/ SPR-1502
$ cd SPR-1502
```

Also available are `SWF-0000-primefaces`, `SWF-0000-richfaces`, and `SWF-0000-jsf`.

2\. Review the list of dependencies and version numbers and modify the pom.xml as necessary.


3\. Import the project into your IDE and modify it as necessary to reproduce your issue. It is already a buildable Maven project, so you may use your IDE's built-in support for Maven to do the importing or generate the IDE settings before importing (e.g. `mvn eclipse:eclipse`).

4\. Add, commit, and push your local fork

```bash
git add SPR-1502
git commit -m "Add repro project for SPR-1502"
git push
```

5\. [Send a pull request from the Github web interface](https://help.github.com/send-pull-requests/)

* The Spring Web Flow team will be notified and will look at your request

... and that's it!

## FAQ

### What if my issue is not a bug, but an improvement or new feature request?

In certain cases, it may make sense to submit a project for improvement requests.  Feel free to submit a project here for your issue if you think it will help us to understand the scenario better.

### What about patches against Spring Web Flow itself? Should I still attach those to my JIRA issue?

For now, yes.  Spring Web Flow will move from it's current home in SVN to Github soon -- when that happens, we may consider pull requests against forks of that repository.

### Can I still attach .zip files to my JIRA issue?  Is it required to use this repository?

Yes, you may still attach zip files if it works best for you.  Submitting pull requests against this repository as described above is the mechanism that the Spring Web Flow team prefers, but what's most important is that we get code from you that reproduces the problem!  Please consider this approach, but zip files are still OK.

