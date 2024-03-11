set -x

FROMDIR=org.osate.contract.repository/target/repository
TODIR=/var/www/html/download/osate/components/contract-annex

rm -fr ${TODIR}
mkdir -p ${TODIR}
cp --recursive ${FROMDIR}/* ${TODIR}/.

