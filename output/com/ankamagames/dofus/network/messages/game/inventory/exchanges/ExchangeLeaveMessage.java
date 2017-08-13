package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.dofus.network.messages.game.dialog.LeaveDialogMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeLeaveMessage extends LeaveDialogMessage implements INetworkMessage {

    private int protocolId = 5628;
    private boolean _isInitialized = false;
    private boolean success = false;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_LeaveDialogMessage(param1);
         param1.writeBoolean(this.success);
    }

    public void deserialize(ICustomDataInput param1) {
         this.dialogType = param1.readByte();
         if(this.dialogType < 0)
         {
            throw new Exception("Forbidden value (" + this.dialogType + ") on element of LeaveDialogMessage.dialogType.");
         }
         this.success = param1.readBoolean();
    }

}