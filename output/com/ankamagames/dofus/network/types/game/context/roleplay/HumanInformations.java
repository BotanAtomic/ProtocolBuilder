package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.character.restriction.ActorRestrictionsInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HumanInformations extends Object implements INetworkType {

    private int protocolId = 157;
    private ActorRestrictionsInformations restrictions;
    private boolean sex = false;
    private HumanOption[] options;
    private FuncTree _restrictionstree;
    private FuncTree _optionstree;


    public void serialize(ICustomDataOutput param1) {
         this.restrictions.serializeAs_ActorRestrictionsInformations(param1);
         param1.writeBoolean(this.sex);
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
         this.restrictions = new ActorRestrictionsInformations();
         this.restrictions.deserialize(param1);
         this.sex = param1.readBoolean();
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