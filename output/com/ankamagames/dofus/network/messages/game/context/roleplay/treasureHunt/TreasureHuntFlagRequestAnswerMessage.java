package com.ankamagames.dofus.network.messages.game.context.roleplay.treasureHunt;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TreasureHuntFlagRequestAnswerMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6507;
    private boolean _isInitialized = false;
    private int questType = 0;
    private int result = 0;
    private int index = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.questType);
         param1.writeByte(this.result);
         if(this.index < 0)
         {
            throw new Exception("Forbidden value (" + this.index + ") on element index.");
         }
         param1.writeByte(this.index);
    }

    public void deserialize(ICustomDataInput param1) {
         this.questType = param1.readByte();
         if(this.questType < 0)
         {
            throw new Exception("Forbidden value (" + this.questType + ") on element of TreasureHuntFlagRequestAnswerMessage.questType.");
         }
         this.result = param1.readByte();
         if(this.result < 0)
         {
            throw new Exception("Forbidden value (" + this.result + ") on element of TreasureHuntFlagRequestAnswerMessage.result.");
         }
         this.index = param1.readByte();
         if(this.index < 0)
         {
            throw new Exception("Forbidden value (" + this.index + ") on element of TreasureHuntFlagRequestAnswerMessage.index.");
         }
    }

}