package com.ankamagames.dofus.network.types.game.guild.tax;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TaxCollectorInformations extends Object implements INetworkType {

    private int protocolId = 167;
    private int uniqueId = 0;
    private int firtNameId = 0;
    private int lastNameId = 0;
    private AdditionalTaxCollectorInformations additionalInfos;
    private int worldX = 0;
    private int worldY = 0;
    private int subAreaId = 0;
    private int state = 0;
    private EntityLook look;
    private TaxCollectorComplementaryInformations[] complements;
    private FuncTree _additionalInfostree;
    private FuncTree _looktree;
    private FuncTree _complementstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.uniqueId);
         if(this.firtNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.firtNameId + ") on element firtNameId.");
         }
         param1.writeVarShort(this.firtNameId);
         if(this.lastNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.lastNameId + ") on element lastNameId.");
         }
         param1.writeVarShort(this.lastNameId);
         this.additionalInfos.serializeAs_AdditionalTaxCollectorInformations(param1);
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
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
         }
         param1.writeVarShort(this.subAreaId);
         param1.writeByte(this.state);
         this.look.serializeAs_EntityLook(param1);
         param1.writeShort(this.complements.length);
         int _loc2_ = 0;
         while(_loc2_ < this.complements.length)
         {
            param1.writeShort((this.complements[_loc2_] as TaxCollectorComplementaryInformations).getTypeId());
            (this.complements[_loc2_] as TaxCollectorComplementaryInformations).serialize(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         TaxCollectorComplementaryInformations _loc5_ = null;
         this.uniqueId = param1.readInt();
         this.firtNameId = param1.readVarUhShort();
         if(this.firtNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.firtNameId + ") on element of TaxCollectorInformations.firtNameId.");
         }
         this.lastNameId = param1.readVarUhShort();
         if(this.lastNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.lastNameId + ") on element of TaxCollectorInformations.lastNameId.");
         }
         this.additionalInfos = new AdditionalTaxCollectorInformations();
         this.additionalInfos.deserialize(param1);
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element of TaxCollectorInformations.worldX.");
         }
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element of TaxCollectorInformations.worldY.");
         }
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of TaxCollectorInformations.subAreaId.");
         }
         this.state = param1.readByte();
         if(this.state < 0)
         {
            throw new Exception("Forbidden value (" + this.state + ") on element of TaxCollectorInformations.state.");
         }
         this.look = new EntityLook();
         this.look.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(TaxCollectorComplementaryInformations,_loc4_);
            _loc5_.deserialize(param1);
            this.complements.push(_loc5_);
            _loc3_++;
         }
    }

}