module "bucket-ate" {
  source = "./modules/s3"
  bucket_name = local.sufix-s3
}

module "vpc-ate" {
  source = "./modules/vpc"
  vpc_cidr = var.vpc_cidr
  name_sufix = local.sufix
  subnet_cidrs_public = var.subnet_cidrs[0]
  subnet_cidrs_private = var.subnet_cidrs[1]
  sg_ingress_ports = var.sg_ingress_ports
  sg_ingress_cidr =  var.sg_ingress_cidr
}

module "ec2-ate" {
  source = "./modules/ec2"
  ami = var.instance_features.ami
  type = var.instance_features.type
  key_name = data.aws_key_pair.key-pair.key_name
  name-sufix = local.sufix
  sg-ec2 = [module.vpc-ate.sg-vpc-id]
  subnetid = module.vpc-ate.public_subnet_id
  script-ec2 = file("script/userdata.sh")
}


module "terraform_state_backend" {
  source = "cloudposse/tfstate-backend/aws"
  version     = "1.5.0"
  namespace  = var.commons_tags.int
  stage      = var.commons_tags.env
  name       = "terraform"
  attributes = ["state"]
  terraform_backend_config_file_path = "."
  terraform_backend_config_file_name = "backend.tf"
  force_destroy                      = true
}
