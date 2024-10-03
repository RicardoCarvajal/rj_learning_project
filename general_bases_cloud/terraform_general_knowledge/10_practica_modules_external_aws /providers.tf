terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "5.69.0"
    }
    random = {
      source = "hashicorp/random"
      version = "3.6.3"
    }
  }
  required_version = "~>1.9.0"
}

provider "aws" {
  region = "us-west-2"
  default_tags {
    tags = var.commons_tags
  }
}