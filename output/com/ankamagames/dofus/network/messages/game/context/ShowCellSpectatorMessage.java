package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ShowCellSpectatorMessage extends ShowCellMessage implements INetworkMessage {

    private int protocolId = 6158;
    private boolean _isInitialized = false;
    private String playerName = "";


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ShowCellMessage(param1);
         param1.writeUTF(this.playerName);
    }

    public void deserialize(ICustomDataInput param1) {
         this.sourceId = param1.readDouble();
         if(this.sourceId < -9.007199254740992E15 || this.sourceId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.sourceId + ") on element of ShowCellMessage.sourceId.");
         }
         this.cellId = param1.readVarUhShort();
         if(this.cellId < 0 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element of ShowCellMessage.cellId.");
         }
         this.playerName = param1.readUTF();
    }

}