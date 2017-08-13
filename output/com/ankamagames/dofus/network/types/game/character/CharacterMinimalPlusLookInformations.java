package package com.ankamagames.dofus.network.types.game.character;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterMinimalPlusLookInformations extends CharacterMinimalInformations implements INetworkType {

    private int protocolId = 163;
    private EntityLook entityLook = ;
    private FuncTree _entityLooktree = ;


    public int getTypeId() {
         return 163;
    }

    public CharacterMinimalPlusLookInformations initCharacterMinimalPlusLookInformations(Number param1,String  param2,int  param3,EntityLook  param4) {
         super.initCharacterMinimalInformations(param1,param2,param3);
         this.entityLook = param4;
         return this;
    }

    public void reset() {
         super.reset();
         this.entityLook = new EntityLook();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_CharacterMinimalPlusLookInformations(param1);
    }

    public void serializeAs_CharacterMinimalPlusLookInformations(ICustomDataOutput param1) {
         super.serializeAs_CharacterMinimalInformations(param1);
         this.entityLook.serializeAs_EntityLook(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterMinimalPlusLookInformations(param1);
    }

    public void deserializeAs_CharacterMinimalPlusLookInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this.entityLook = new EntityLook();
         this.entityLook.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterMinimalPlusLookInformations(param1);
    }

    public void deserializeAsyncAs_CharacterMinimalPlusLookInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         this._entityLooktree = param1.addChild(this._entityLooktreeFunc);
    }

    private void _entityLooktreeFunc(ICustomDataInput param1) {
         this.entityLook = new EntityLook();
         this.entityLook.deserializeAsync(this._entityLooktree);
    }

}