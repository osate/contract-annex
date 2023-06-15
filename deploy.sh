set -x

FROMDIR=org.osate.contract.repository/target/repository
TODIR=/var/www/html/p2/contract-annex

rm -fr ${TODIR}
mkdir -p ${TODIR}
cp --recursive ${FROMDIR}/* ${TODIR}/.

