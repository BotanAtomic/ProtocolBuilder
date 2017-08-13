package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameRolePlayMerchantInformations extends GameRolePlayNamedActorInformations implements INetworkType {

    private int protocolId = 129;
    private int sellType = 0;
    private HumanOption[] options;
    private FuncTree _optionstree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayActorInformations(param1);
         param1.writeUTF(this.name);
         if(this.sellType < 0)
         {
            throw new Exception("Forbidden value (" + this.sellType + ") on element sellType.");
         }
         param1.writeByte(this.sellType);
         param1.writeShort(this.options.length);
         int _loc2_ = 0;
         while(_loc2_ < this.options.length)
         {
            param1.writeShort((this.options[_loc2_] as HumanOption).getTypeId());
            (this.options[_loc2_] as HumanOption).serialize(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         HumanOption _loc5_ = null;
         this.deserializeAs_GameRolePlayNamedActorInformations(param1);
         this.sellType = param1.readByte();
         if(this.sellType < 0)
         {
            throw new Exception("Forbidden value (" + this.sellType + ") on element of GameRolePlayMerchantInformations.sellType.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(HumanOption,_loc4_);
            _loc5_.deserialize(param1);
            this.options.push(_loc5_);
            _loc3_++;
         }
    }

}