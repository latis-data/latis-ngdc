package latis.reader

import org.junit._
import Assert._
import latis.reader.tsml.TsmlReader
import scala.collection.mutable.ArrayBuffer
import latis.writer.AsciiWriter
import latis.ops.Operation
import latis.ops.filter.Selection
import latis.ops.Projection

class TestNetcdfAdapter {

  @Test
  def test {
    val tsml = "datasets/g15_epead_a16e_32s.tsml"
      
    val ops = ArrayBuffer[Operation]()
    ops += Selection("time >= 2014-04-01T01:00:00")
    ops += Selection("time <  2014-04-01T01:15:00")
    ops += Projection("time,A1E_FLUX")
    
    val ds = TsmlReader(tsml).getDataset(ops)
    
    assertEquals(6, ds.length)
    assertEquals(2, ds.toSeq.length)
    
    
    //ops += Selection("time_tag < 1.3963149e12")
    //ops += Selection("A1E_CR>0")
    //ops += Operation("first")
    //ops += Operation("last")
    //ops += LimitFilter(3)
    
    //AsciiWriter.write(ds)
    
  }
}