variable "instances" {
  description = "Nombres de las intancias"
  type        = list(string)
  default     = ["apache"]
}

resource "aws_instance" "ec2-primary" {
  for_each               = toset(var.instances)
  ami                    = var.instance_features.ami
  instance_type          = var.instance_features.type
  subnet_id              = aws_subnet.subnet-ate-public.id
  key_name               = data.aws_key_pair.key-pair.key_name
  vpc_security_group_ids = [aws_security_group.sg-ate.id]
  tags = {
    Name = "${local.sufix}-ec2-${each.value}"
  }
}

resource "aws_instance" "ec2-monitoring" {
  count                  = var.enable_monitoring ? 1 : 0
  ami                    = var.instance_features.ami
  instance_type          = var.instance_features.type
  subnet_id              = aws_subnet.subnet-ate-public.id
  key_name               = data.aws_key_pair.key-pair.key_name
  vpc_security_group_ids = [aws_security_group.sg-ate.id]
  tags = {
    Name = "${local.sufix}-ec2-monitoring"
  }
}