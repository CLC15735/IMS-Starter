Coverage: 34%
# Project Title

INVENTORY MANAGEMENT SYSTEM

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Version Control System: Git
	-Remote: GitHub
	-Local: GitBash

Software: Java 7
Development tools: Eclipse or Maven
Testing: JUnit
Database management: MySQL 5.7

### Installing


1. Set up the development environment:
	- Fork/Clone the dev branch of this repository using GitHub
2. Set up the connection to your own MySQL database
	- On src\main\java\com\qa\ims\utils go to DBUtils and change the Username and Password to your own ones
3. The environement should be all set and ready for a test run in the Runner.

## Running the tests

The tests are performed for customer, order and item for each three of the classes (domain, DAO and controller)

### Unit Tests 

The domain tests use EqualsVerifier to determine if the contract for equals and hashCode methods in a class is met.
The DAO tests use assertEquals(). In this case we feed the DAO the information it requires for a certain task, and the assertEquals method will compare the output with the output expected (created by the user).
The controller tests use Mockito to verify that the information we are passing on to the DAO is correct.

### Integration Tests 


### And coding style tests


## Deployment



## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)


## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
