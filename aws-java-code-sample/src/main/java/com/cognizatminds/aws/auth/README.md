Working with AWS Credentials

To make requests to Amazon Web Services, you will need to supply AWS credentials to the AWS SDK for Java. There are a number of ways to do this:

Use the default credential provider chain (recommended)
Use a specific credential provider or provider chain (or create your own).
Supply the credentials yourself. These can be either root account credentials, IAM credentials or temporary credentials retrieved from AWS STS.

Using the Default Credential Provider Chain#

When you initialize a new service client without supplying any arguments, the AWS SDK for Java will attempt to find AWS credentials using the default credential provider chain implemented by the DefaultAWSCredentialsProviderChain class. The default credential provider chain looks for credentials in this order:

Environment Variables – AWS_ACCESS_KEY_ID and AWS_SECRET_ACCESS_KEY. The AWS SDK for Java uses the EnvironmentVariableCredentialsProvider class to load these credentials.

Java System Properties – aws.accessKeyId and aws.secretKey. The AWS SDK for Java uses the SystemPropertiesCredentialsProvider to load these credentials.

The default credential profiles file – typically located at ~/.aws/credentials (this location may vary per platform), this credentials file is shared by many of the AWS SDKs and by the AWS CLI. The AWS SDK for Java uses the ProfileCredentialsProvider to load these credentials.

You can create a credentials file by using the aws configure command provided by the AWS CLI, or you can create it by hand-editing the file with a text editor. For information about the credentials file format, see AWS Credentials File Format.

Amazon ECS container credentials – loaded from the Amazon EC2 Container Service if the environment variable AWS_CONTAINER_CREDENTIALS_RELATIVE_URI is set. The AWS SDK for Java uses the ContainerCredentialsProvider to load these credentials.

Instance profile credentials – used on EC2 instances, and delivered through the Amazon EC2 metadata service. The AWS SDK for Java uses the InstanceProfileCredentialsProvider to load these credentials.



More details: 
	http://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html
	http://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/java-dg-roles.html


