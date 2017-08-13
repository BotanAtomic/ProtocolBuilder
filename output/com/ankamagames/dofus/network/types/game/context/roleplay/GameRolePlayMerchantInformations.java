package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameRolePlayMerchantInformations extends GameRolePlayNamedActorInformations implements INetworkType {

    private int protocolId = 129;
    private int sellType = 0;
    private Vector<HumanOption> options;
    private FuncTree _optionstree;


    public int getTypeId() {
         return 129;
    }

    public GameRolePlayMerchantInformations initGameRolePlayMerchantInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3,String  param4,int  param5,Vector<HumanOption>  param6) {
         super.initGameRolePlayNamedActorInformations(param1,param2,param3,param4);
         this.sellType = param5;
         this.options = param6;
         return this;
    }

    public void reset() {
         super.reset();
         this.sellType = 0;
         this.options = new Vector.<HumanOption>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameRolePlayMerchantInformations(param1);
    }

    public void serializeAs_GameRolePlayMerchantInformations(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayNamedActorInformations(param1);
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
         this.deserializeAs_GameRolePlayMerchantInformations(param1);
    }

    public void deserializeAs_GameRolePlayMerchantInformations(ICustomDataInput param1) {
         int _loc4_ = 0;
         HumanOption _loc5_ = null;
         super.deserialize(param1);
         this._sellTypeFunc(param1);
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

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayMerchantInformations(param1);
    }

    public void deserializeAsyncAs_GameRolePlayMerchantInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._sellTypeFunc);
         this._optionstree = param1.addChild(this._optionstreeFunc);
    }

    private void _sellTypeFunc(ICustomDataInput param1) {
         this.sellType = param1.readByte();
         if(this.sellType < 0)
         {
            throw new Exception("Forbidden value (" + this.sellType + ") on element of GameRolePlayMerchantInformations.sellType.");
         }
    }

    private void _optionstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._optionstree.addChild(this._optionsFunc);
            _loc3_++;
         }
    }

    private void _optionsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         HumanOption _loc3_ = ProtocolTypeManager.getInstance(HumanOption,_loc2_);
         _loc3_.deserialize(param1);
         this.options.push(_loc3_);
    }

}