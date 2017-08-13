package com.ankamagames.dofus.network.messages.debug;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class DebugHighlightCellsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 2001;
    private boolean _isInitialized = false;
    private int color = 0;
    private int[] cells;
    private FuncTree _cellstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.color);
         param1.writeShort(this.cells.length);
         int _loc2_ = 0;
         while(_loc2_ < this.cells.length)
         {
            if(this.cells[_loc2_] < 0 || this.cells[_loc2_] > 559)
            {
               throw new Exception("Forbidden value (" + this.cells[_loc2_] + ") on element 2 (starting at 1) of cells.");
            }
            param1.writeVarShort(this.cells[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         this.color = param1.readInt();
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readVarUhShort();
            if(_loc4_ < 0 || _loc4_ > 559)
            {
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of cells.");
            }
            this.cells.push(_loc4_);
            _loc3_++;
         }
    }

}