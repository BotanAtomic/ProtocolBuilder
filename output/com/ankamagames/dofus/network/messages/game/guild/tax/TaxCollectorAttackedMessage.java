package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicGuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TaxCollectorAttackedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5918;
    private boolean _isInitialized = false;
    private int firstNameId = 0;
    private int lastNameId = 0;
    private int worldX = 0;
    private int worldY = 0;
    private int mapId = 0;
    private int subAreaId = 0;
    private BasicGuildInformations guild;
    private FuncTree _guildtree;


    public void serialize(ICustomDataOutput param1) {
         if(this.firstNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.firstNameId + ") on element firstNameId.");
         }
         param1.writeVarShort(this.firstNameId);
         if(this.lastNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.lastNameId + ") on element lastNameId.");
         }
         param1.writeVarShort(this.lastNameId);
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element worldX.");
         }
         param1.writeShort(this.worldX);
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element worldY.");
         }
         param1.writeShort(this.worldY);
         param1.writeInt(this.mapId);
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
         }
         param1.writeVarShort(this.subAreaId);
         this.guild.serializeAs_BasicGuildInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.firstNameId = param1.readVarUhShort();
         if(this.firstNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.firstNameId + ") on element of TaxCollectorAttackedMessage.firstNameId.");
         }
         this.lastNameId = param1.readVarUhShort();
         if(this.lastNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.lastNameId + ") on element of TaxCollectorAttackedMessage.lastNameId.");
         }
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element of TaxCollectorAttackedMessage.worldX.");
         }
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element of TaxCollectorAttackedMessage.worldY.");
         }
         this.mapId = param1.readInt();
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of TaxCollectorAttackedMessage.subAreaId.");
         }
         this.guild = new BasicGuildInformations();
         this.guild.deserialize(param1);
    }

}