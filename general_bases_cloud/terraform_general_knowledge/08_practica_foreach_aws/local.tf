locals {
  sufix = "${var.commons_tags.env}-${var.commons_tags.int}-${var.commons_tags.country}"
}

locals {
  sufix-s3 = "${var.commons_tags.env}-${var.commons_tags.int}-${var.commons_tags.country}-${random_string.bucket-sufix.id}"
}

resource "random_string" "bucket-sufix" {
  length = 8
  upper = false
  special = false  
}