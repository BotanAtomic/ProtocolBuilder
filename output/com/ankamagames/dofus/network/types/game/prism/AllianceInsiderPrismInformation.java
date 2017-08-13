package com.ankamagames.dofus.network.types.game.prism;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class AllianceInsiderPrismInformation extends PrismInformation implements INetworkType {

    private int protocolId = 431;
    private int lastTimeSlotModificationDate = 0;
    private int lastTimeSlotModificationAuthorGuildId = 0;
    private Number lastTimeSlotModificationAuthorId = 0;
    private String lastTimeSlotModificationAuthorName = "";
    private ObjectItem[] modulesObjects;
    private FuncTree _modulesObjectstree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_PrismInformation(param1);
         if(this.lastTimeSlotModificationDate < 0)
         {
            throw new Exception("Forbidden value (" + this.lastTimeSlotModificationDate + ") on element lastTimeSlotModificationDate.");
         }
         param1.writeInt(this.lastTimeSlotModificationDate);
         if(this.lastTimeSlotModificationAuthorGuildId < 0)
         {
            throw new Exception("Forbidden value (" + this.lastTimeSlotModificationAuthorGuildId + ") on element lastTimeSlotModificationAuthorGuildId.");
         }
         param1.writeVarInt(this.lastTimeSlotModificationAuthorGuildId);
         if(this.lastTimeSlotModificationAuthorId < 0 || this.lastTimeSlotModificationAuthorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.lastTimeSlotModificationAuthorId + ") on element lastTimeSlotModificationAuthorId.");
         }
         param1.writeVarLong(this.lastTimeSlotModificationAuthorId);
         param1.writeUTF(this.lastTimeSlotModificationAuthorName);
         param1.writeShort(this.modulesObjects.length);
         int _loc2_ = 0;
         while(_loc2_ < this.modulesObjects.length)
         {
            (this.modulesObjects[_loc2_] as ObjectItem).serializeAs_ObjectItem(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         ObjectItem _loc4_ = null;
         this.contextualId = param1.readDouble();
         if(this.contextualId < -9.007199254740992E15 || this.contextualId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.contextualId + ") on element of GameContextActorInformations.contextualId.");
         }
         this.look = new EntityLook();
         this.look.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.disposition = ProtocolTypeManager.getInstance(EntityDispositionInformations,_loc2_);
         this.disposition.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.prism = ProtocolTypeManager.getInstance(PrismInformation,_loc2_);
         this.prism.deserialize(param1);
         this.lastTimeSlotModificationDate = param1.readInt();
         if(this.lastTimeSlotModificationDate < 0)
         {
            throw new Exception("Forbidden value (" + this.lastTimeSlotModificationDate + ") on element of AllianceInsiderPrismInformation.lastTimeSlotModificationDate.");
         }
         this.lastTimeSlotModificationAuthorGuildId = param1.readVarUhInt();
         if(this.lastTimeSlotModificationAuthorGuildId < 0)
         {
            throw new Exception("Forbidden value (" + this.lastTimeSlotModificationAuthorGuildId + ") on element of AllianceInsiderPrismInformation.lastTimeSlotModificationAuthorGuildId.");
         }
         this.lastTimeSlotModificationAuthorId = param1.readVarUhLong();
         if(this.lastTimeSlotModificationAuthorId < 0 || this.lastTimeSlotModificationAuthorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.lastTimeSlotModificationAuthorId + ") on element of AllianceInsiderPrismInformation.lastTimeSlotModificationAuthorId.");
         }
         this.lastTimeSlotModificationAuthorName = param1.readUTF();
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new ObjectItem();
            _loc4_.deserialize(param1);
            this.modulesObjects.push(_loc4_);
            _loc3_++;
         }
    }

}