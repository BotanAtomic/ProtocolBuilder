package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameContextRemoveElementWithEventMessage extends GameContextRemoveElementMessage implements INetworkMessage {

    private int protocolId = 6412;
    private boolean _isInitialized = false;
    private int elementEventId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeDouble(this.id);
         if(this.elementEventId < 0)
         {
            throw new Exception("Forbidden value (" + this.elementEventId + ") on element elementEventId.");
         }
         param1.writeByte(this.elementEventId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.id = param1.readDouble();
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of GameContextRemoveElementMessage.id.");
         }
         this.elementEventId = param1.readByte();
         if(this.elementEventId < 0)
         {
            throw new Exception("Forbidden value (" + this.elementEventId + ") on element of GameContextRemoveElementWithEventMessage.elementEventId.");
         }
    }

}