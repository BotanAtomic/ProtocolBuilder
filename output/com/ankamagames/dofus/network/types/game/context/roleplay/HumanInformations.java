package package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.character.restriction.ActorRestrictionsInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HumanInformations extends Object implements INetworkType {

    private int protocolId = 157;
    private ActorRestrictionsInformations restrictions = ;
    private boolean sex = false;
    private Vector.<HumanOption> options = ;
    private FuncTree _restrictionstree = ;
    private FuncTree _optionstree = ;
    private int _loc2_ = 0;
    private HumanOption _loc5_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private HumanOption _loc3_ = ProtocolTypeManager.getInstance(HumanOption,_loc2_);


    public int getTypeId() {
         return 157;
    }

    public HumanInformations initHumanInformations(ActorRestrictionsInformations param1,boolean  param2,Vector.<HumanOption>  param3) {
         this.restrictions = param1;
         this.sex = param2;
         this.options = param3;
         return this;
    }

    public void reset() {
         this.restrictions = new ActorRestrictionsInformations();
         this.options = new Vector.<HumanOption>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_HumanInformations(param1);
    }

    public void serializeAs_HumanInformations(ICustomDataOutput param1) {
         this.restrictions.serializeAs_ActorRestrictionsInformations(param1);
         param1.writeBoolean(this.sex);
         param1.writeShort(this.options.length);
         int _loc2_ = 0;
         while(_loc2_ < this.options.length)
            param1.writeShort((this.options[_loc2_] as HumanOption).getTypeId());
            (this.options[_loc2_] as HumanOption).serialize(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HumanInformations(param1);
    }

    public void deserializeAs_HumanInformations(ICustomDataInput param1) {
         int _loc4_ = 0;
         HumanOption _loc5_ = null;
         this.restrictions = new ActorRestrictionsInformations();
         this.restrictions.deserialize(param1);
         this._sexFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(HumanOption,_loc4_);
            _loc5_.deserialize(param1);
            this.options.push(_loc5_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HumanInformations(param1);
    }

    public void deserializeAsyncAs_HumanInformations(FuncTree param1) {
         this._restrictionstree = param1.addChild(this._restrictionstreeFunc);
         param1.addChild(this._sexFunc);
         this._optionstree = param1.addChild(this._optionstreeFunc);
    }

    private void _restrictionstreeFunc(ICustomDataInput param1) {
         this.restrictions = new ActorRestrictionsInformations();
         this.restrictions.deserializeAsync(this._restrictionstree);
    }

    private void _sexFunc(ICustomDataInput param1) {
         this.sex = param1.readBoolean();
    }

    private void _optionstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._optionstree.addChild(this._optionsFunc);
            _loc3_++;
    }

    private void _optionsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         HumanOption _loc3_ = ProtocolTypeManager.getInstance(HumanOption,_loc2_);
         _loc3_.deserialize(param1);
         this.options.push(_loc3_);
    }

}