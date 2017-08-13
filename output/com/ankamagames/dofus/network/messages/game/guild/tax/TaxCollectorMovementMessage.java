package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.tax.TaxCollectorBasicInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TaxCollectorMovementMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5633;
    private boolean _isInitialized = false;
    private int movementType = 0;
    private TaxCollectorBasicInformations basicInfos;
    private Number playerId = 0;
    private String playerName = "";
    private FuncTree _basicInfostree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.movementType);
         this.basicInfos.serializeAs_TaxCollectorBasicInformations(param1);
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
         }
         param1.writeVarLong(this.playerId);
         param1.writeUTF(this.playerName);
    }

    public void deserialize(ICustomDataInput param1) {
         this.movementType = param1.readByte();
         if(this.movementType < 0)
         {
            throw new Exception("Forbidden value (" + this.movementType + ") on element of TaxCollectorMovementMessage.movementType.");
         }
         this.basicInfos = new TaxCollectorBasicInformations();
         this.basicInfos.deserialize(param1);
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element of TaxCollectorMovementMessage.playerId.");
         }
         this.playerName = param1.readUTF();
    }

}